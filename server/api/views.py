# coding=utf-8
import logging
import random

from api.models.car import Car
from api.models.user import User
from flask import jsonify, request

logger = logging.getLogger(__name__)


def add_dummy_car():
    u = User.get_user('351.394.078.80')
    u.name = 'Mário do'
    u.phone = '(11) 223-244-523'
    u.driver_license = '123.55.13.2.13.23'
    u_key = u.put()

    license_plate = ''.join(random.choice('ABCDEFGH') for _ in range(3)) + \
                    ''.join(random.choice('1234567890') for _ in range(4))
    c = Car.get_car(license_plate)
    c.brand = 'Mercedes'
    c.model = 'Classe ' + random.choice('ABCD')
    c.year = 2007
    c.optionals = ['Ar Condicionado', 'Trio Elétrica']
    c.price = 250
    c.fuel = 'Gasolina'
    c.available_slots = ['8:00', '10:00', '11:00']
    c.owner = u_key
    c_key = c.put()
    return jsonify({
        'user': u_key.id(),
        'car': c_key.id(),
    })


def cars():
    if request.method == 'POST':
        return add_car()
    else:
        return list_cars()


def add_car():
    try:
        logging.info("NOVOO CARROOOO %r", request.form)
        logging.info("NOVOO OWNER %r", request.form['owner_cpf'])
        u = User.get_user(request.form['owner_cpf'])
        u.name = request.form.get('owner_name')
        u.phone = request.form.get('owner_phone')
        u.driver_license = request.form.get('owner_driver_license')
        u_key = u.put()

        c = Car.get_car(request.form.get('license_plate'))
        c.brand = request.form.get('brand')
        c.model = request.form.get('model')
        c.year = int(request.form.get('year'))
        c.optionals = request.form.get('optionals')
        c.price = int(request.form.get('price'))
        c.fuel = request.form.get('fuel')
        c.available_time_range = request.form.get('available_time_range')
        c.owner = u_key
        c_key = c.put()

        return jsonify({
            'status': 'ok',
            'message': 'Carro criado com sucesso!',
            'car_key': c_key.id(),
        })

    except Exception, e:
        logger.error("Error saving car %r", e)
        return jsonify({
            'status': 'fail',
            'message': e.message,
        })


def list_cars():
    return jsonify({
        'items': [c.to_dict() for c in Car.query()],
    })
