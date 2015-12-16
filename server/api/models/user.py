# coding=utf-8
import re
from google.appengine.ext import ndb


def check_cpf(value):
    num = re.sub(r'[^0-9]', '', value)
    if len(num) != 11:
        raise ValueError('CPF Inválido')
    return num


class User(ndb.Model):
    name = ndb.StringProperty()
    phone = ndb.StringProperty()
    driver_license = ndb.StringProperty()

    @classmethod
    def get_user(cls, cpf):
        return cls.get_or_insert(check_cpf(cpf))
