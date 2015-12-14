"""`main` is the top level module for your Flask application."""

# Import the Flask Framework
from flask import Flask, render_template, jsonify, abort, make_response

app = Flask(__name__)
# Note: We don't need to call run() since our application is embedded within
# the App Engine WSGI application server.


@app.route('/')
def hello():
    """Return a friendly HTTP greeting."""
    return 'Hello World!'


@app.route('/list/')
def list_entries():
    return render_template('show_entries.html', entries=[])


@app.route('/api/v1/tasks', methods=['GET'])
def get_tasks():
    return jsonify({'tasks': []})


@app.route('/api/v1/tasks/<int:task_id>', methods=['GET'])
def get_task(task_id):
    if task_id <= 0:
        abort(404)
    return jsonify({'task': task_id})


@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'error': 'Not found'}), 404)


@app.errorhandler(500)
def application_error(e):
    """Return a custom 500 error."""
    return 'Sorry, unexpected error: {}'.format(e), 500
