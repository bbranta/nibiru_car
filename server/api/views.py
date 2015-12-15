from api.models.greeting import Greeting
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
    greeting.content = "Bl2a " + str(task_id)
    greeting.put()
    return jsonify({'task': str(greeting)})