# coding=utf-8
from google.appengine.ext import ndb


class Greeting(ndb.Model):
    """Models an individual Guestbook entry with content and date."""
    content = ndb.StringProperty()
    date = ndb.DateTimeProperty(auto_now_add=True)

    @classmethod
    def query_all(cls):
        return cls.query(ancestor=ancestor_key).order(-cls.date)
