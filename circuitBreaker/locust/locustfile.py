import time
from locust import HttpUser, task, between

class QuickstartUser(HttpUser):
    wait_time = between(1, 5)
    network_timeout = 1.0
    connection_timeout = 1.0
    host = "{{ ip }}:8080"

    @task
    def hello_world(self):
        # delay = 5 sec
        # timeout = 5 sec
        self.client.get("/test?delay=5000", timeout=5)

