# Generated by Django 2.2.4 on 2019-11-25 22:26

import django.core.validators
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('suggest', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='suggestion',
            name='depressed_level',
            field=models.CharField(default='null', max_length=100),
        ),
        migrations.AddField(
            model_name='suggestion',
            name='score',
            field=models.IntegerField(default=0, validators=[django.core.validators.MinValueValidator(0), django.core.validators.MaxValueValidator(100)]),
        ),
        migrations.AlterField(
            model_name='suggestion',
            name='text',
            field=models.CharField(default='null', max_length=500),
        ),
    ]
