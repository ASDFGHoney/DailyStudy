from django.shortcuts import render


def landing(request):
    return render(request, "landing/index.html")


def blog(request):
    return render(request, "landing/blog.html")


def cafe(request):
    return render(request, "landing/cafe.html")


def mail(request):
    return render(request, "landing/mail.html")


def shop(request):
    return render(request, "landing/shop.html")
