from django.db import models

# Create your models here.


class BlogPost(models.Model):
    title = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)  # 추가할때 한번만 됨
    content = models.TextField()
    updated_at = models.DateTimeField(auto_now=True)  # 업데이트 할때마다 됨
