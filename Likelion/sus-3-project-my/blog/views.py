from django.shortcuts import render, redirect

from blog.models import BlogPost
# Create your views here.


def temp(request):

    # Create
    # new_post = BlogPost()
    # new_post.title = "new post title"
    # new_post.content = "new post content"
    # new_post.save()

    # Read
    # post_list = BlogPost.objects.all()
    # for post in post_list:
    #     print(post.title)
    # first_post = BlogPost.objects.get(id=2)
    # print(f"title: {first_post.title}")
    # print(f"content: {first_post.content}")
    # print(f"created: {first_post.created_at}")

    # Update
    # target_post = BlogPost.objects.get(id=3)
    # target_post.title = "title 3"
    # target_post.content = "post content 3"
    # target_post.save()

    # Delete
    # target_post = BlogPost.objects.all().order_by("-pk")[0]
    # target_post.delete()

    return render(request, "blog/index.html")


def createe(request):
    if request.method == "POST":

        new_post = BlogPost()
        new_post.title = request.POST.get("title")
        new_post.content = request.POST.get("content")
        new_post.save()

        print(request.POST.get("title"))
        print(request.POST.get("content"))

        return redirect("/blog/home/")

    elif request.method == "GET":
        return render(request, "blog/create.html")


def readd(request):
    return render(request, "blog/read.html")


def updatee(request):
    return render(request, "blog/update.html")


def deletee(request):
    return render(request, "blog/delete.html")
