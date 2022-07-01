from django.urls import path

from . import views

urlpatterns = [
    path("home/", views.landing),
    path("blog/", views.blog),
    path("cafe/", views.cafe),
    path("mail/", views.mail),
    path("shop/", views.shop),
]
