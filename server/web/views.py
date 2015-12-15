from flask import render_template


def hello():
    """Return a friendly HTTP greeting."""
    return render_template('layout.html', content='Hello World!')


def list_entries():
    return render_template('show_entries.html', entries=[])



