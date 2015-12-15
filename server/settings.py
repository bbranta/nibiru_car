import os

PRODUCTION = os.environ.get("SERVER_SOFTWARE", "").startswith("Google")
DEVELOPMENT = not PRODUCTION
DEBUG = DEVELOPMENT
