import views


def init(app):
    app.add_url_rule('/', view_func=views.hello, methods=['GET'])
    app.add_url_rule('/list/', view_func=views.list_entries, methods=['GET'])
