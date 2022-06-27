from django.urls import path

from landing import views

urlpatterns = [
    path("home/", views.landing),
]
