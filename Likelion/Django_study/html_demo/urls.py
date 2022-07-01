from django.urls import path

from html_demo import views

urlpatterns = [
    path("css-quiz-1/", views.css_quiz_1),
    path("css-quiz-3/", views.css_quiz_3),
]
