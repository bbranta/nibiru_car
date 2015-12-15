from flask import Flask, make_response, jsonify
import settings
import urls

app = Flask('nibiru-api')
app.config.from_object(settings)


@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'error': 'Not found'}), 404)


urls.init(app)
