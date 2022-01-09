# Generated by Django 4.0.1 on 2022-01-08 12:33

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('django_api', '0006_transaction_expense_type'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='transaction',
            name='transaction_limit',
        ),
        migrations.AddField(
            model_name='account',
            name='account_limit',
            field=models.DecimalField(decimal_places=2, default=1, max_digits=8),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='account',
            name='owner',
            field=models.IntegerField(default=1),
            preserve_default=False,
        ),
        migrations.AlterField(
            model_name='account',
            name='date_of_creation',
            field=models.DateField(auto_now_add=True),
        ),
        migrations.AlterField(
            model_name='transaction',
            name='date_of_occurrence',
            field=models.DateField(auto_now_add=True),
        ),
    ]
