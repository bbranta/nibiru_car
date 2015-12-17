import views


def init(app):
    app.add_url_rule('/api/v1/cars', view_func=views.cars,
                     methods=['GET', 'POST'])
    app.add_url_rule('/api/v1/add_dummy_car', view_func=views.add_dummy_car,
                     methods=['GET'])
