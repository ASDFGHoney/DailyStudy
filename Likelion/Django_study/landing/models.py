from django.db import models

# Create your models here.


class BlogPost(models.Model):
    title = models.CharField(max_length=128)
    content = models.TextField()
    writer = models.CharField(max_length=32)
    password = models.CharField(max_length=128)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
