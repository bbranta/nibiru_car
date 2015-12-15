from flask import jsonify, abort


def get_tasks():
    return jsonify({'tasks': []})


def get_task(task_id):
    if task_id <= 0:
        abort(404)
    return jsonify({'task': task_id})
