# Generated by Django 4.0.1 on 2022-01-08 14:28

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('django_api', '0007_remove_transaction_transaction_limit_and_more'),
    ]

    operations = [
        migrations.AlterField(
            model_name='customer',
            name='date_of_birth',
            field=models.DateField(),
        ),
    ]