from django.shortcuts import render

# Create your views here.


def landing(request):
    return render(request, "landing/index.html")


def resume(request):
    return render(request, "landing/resume.html")


def project(request):
    return render(request, "landing/project.html")
