from django.contrib import admin

from blog import models
# Register your models here.

# 주어진 모델을 관리자가 관리하도록 등록함
admin.site.register(models.BlogPost)
