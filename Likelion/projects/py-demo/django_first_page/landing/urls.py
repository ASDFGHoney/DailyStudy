from django.urls import path

from landing import views

urlpatterns = [
    path("home/", views.landing),
    path("resume/", views.resume),
    path("project/", views.project)
]
