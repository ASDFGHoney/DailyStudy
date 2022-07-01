from django.urls import path

from blog import views

urlpatterns = [
    path("create/", views.createe),
    path("read/", views.readd),
    path("delete/", views.deletee),
    path("update/", views.updatee),
    path("home/", views.temp),
]
