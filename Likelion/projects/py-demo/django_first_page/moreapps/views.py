from django.shortcuts import render

# Create your views here.


def landing(request):
    return render(request, "more/index.html")


def mail(request):
    return render(request, "more/mail.html")


def cafe(request):
    return render(request, "more/cafe.html")


def blog(request):
    return render(request, "more/blog.html")


def shop(request):
    return render(request, "more/shop.html")
