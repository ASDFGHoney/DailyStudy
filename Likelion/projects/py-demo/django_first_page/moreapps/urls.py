from django.urls import path

from moreapps import views

urlpatterns = [
    path("home/", views.landing),
    path("mail/", views.mail),
    path("cafe/", views.cafe),
    path("blog/", views.blog),
    path("shop/", views.shop),
]
