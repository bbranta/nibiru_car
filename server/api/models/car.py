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
    optionals = ndb.IntegerProperty()
    price = ndb.FloatProperty()
    fuel = ndb.StringProperty()
    available_date = ndb.StringProperty()
    available_start_time = ndb.IntegerProperty()
    available_end_time = ndb.IntegerProperty()
    owner = ndb.KeyProperty(User)

    @classmethod
    def get_car(cls, license_plate):
        return cls.get_or_insert(check_license_plate(license_plate))

    def to_dict(self):
        d = super(Car, self).to_dict()
        d['license_plate'] = self.key.id()
        d['owner'] = User.get_user(d['owner'].id()).to_dict() \
            if d['owner'] else None
        return d