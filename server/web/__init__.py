from flask import Flask
import settings
import urls

app = Flask('nibiru-car')
app.config.from_object(settings)


@app.errorhandler(500)
def application_error(e):
    """Return a custom 500 error."""
    return 'Sorry, unexpected error: {}'.format(e), 500


urls.init(app)