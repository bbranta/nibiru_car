import views


def init(app):
    app.add_url_rule('/api/v1/cars', view_func=views.list_cars,
                     methods=['GET'])
    app.add_url_rule('/api/v1/tasks/<int:task_id>', view_func=views.get_task,
                     methods=['GET'])
    app.add_url_rule('/api/v1/tasks/<int:task_id>/add',
                     view_func=views.add_task, methods=['GET'])
