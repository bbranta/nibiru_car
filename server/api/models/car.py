# coding=utf-8
import re
from google.appengine.ext import ndb

from api.models.user import User


def check_license_plate(value):
    num = re.sub(r'[^0-9A-Z]', '', value)
    if len(num) != 7:
        raise ValueError('Placa Inválida')
    return num


class Car(ndb.Model):
    model = ndb.StringProperty()
    brand = ndb.StringProperty()
    year = ndb.IntegerProperty()
    optionals = ndb.StringProperty(repeated=True)
    price = ndb.IntegerProperty()
    available_slots = ndb.StringProperty(repeated=True)
    fuel = ndb.StringProperty()
    owner = ndb.KeyProperty(User)

    @classmethod
    def get_car(cls, license_plate):
        return cls.get_or_insert(check_license_plate(license_plate))

    def to_dict(self):
        d = super(Car, self).to_dict()
        d['license_plate'] = self.key.id()
        d['owner'] = User.get_user(d['owner'].id()).to_dict()
        return d