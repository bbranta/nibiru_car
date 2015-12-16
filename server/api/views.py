# coding=utf-8
from api.models.car import Car
from api.models.greeting import Greeting
from api.models.user import User
from flask import jsonify, abort


def get_tasks():
    return jsonify({
        'tasks': [str(s) for s in Greeting.query_all()],
    })


def get_task(task_id):
    if task_id <= 0:
        abort(404)
    return jsonify({'task': task_id})


def add_task(task_id):
    greeting = Greeting.get_or_insert(str(task_id))
    greeting.content = 'Bl2a ' + str(task_id)
    greeting.put()
    return jsonify({'task': str(greeting)})

def dummy():
    u = User.get_user('351.394.078.80')
    u.name = 'Mário do'
    u.phone = '(11) 223-244-523'
    u.driver_license = '123.55.13.2.13.23'
    u_key = u.put()

    c = Car.get_car('ABC-1236')
    c.brand = 'Mercedes'
    c.model = 'Classe B'
    c.year = 2007
    c.optionals = ['Ar Condicionado', 'Trio Elétrica']
    c.price = 250
    c.fuel = 'Gasolina'
    c.available_slots = ['8:00', '10:00', '11:00']
    c.owner = u_key
    c.put()
    return jsonify({})


def list_cars():
    return jsonify({
        'items': [c.to_dict() for c in Car.query()],
    })
