from django.db import models

# Create your models here.


class ExpenseType(models.Model):
    id = models.AutoField(primary_key=True)
    description = models.CharField(max_length=30)

    def __str__(self) -> str:
        return self.description


class TransactionType(models.Model):
    id = models.AutoField(primary_key=True)
    description = models.CharField(max_length=30)

    def __str__(self) -> str:
        return self.description


class Customer(models.Model):
    id = models.AutoField(primary_key=True)
    firstname = models.CharField(max_length=20)
    lastname = models.CharField(max_length=20)
    gender = models.CharField(max_length=6)
    svnr = models.IntegerField()
    date_of_birth = models.DateField()
    street_with_no = models.CharField(max_length=30)
    city = models.CharField(max_length=30)
    postal_code = models.CharField(max_length=4)

    def __str__(self) -> str:
        return self.firstname


class Account(models.Model):
    id = models.AutoField(primary_key=True)
    owner = models.ForeignKey(
        Customer, on_delete=models.SET_NULL, null=True)
    account_type = models.CharField(max_length=20)
    date_of_creation = models.DateField(auto_now_add=True)
    iban = models.CharField(max_length=27)
    bic = models.CharField(max_length=10)
    balance = models.DecimalField(decimal_places=2, max_digits=8)
    currency = models.CharField(max_length=3)
    account_limit = models.DecimalField(decimal_places=2, max_digits=8)

    def __str__(self) -> str:
        return self.iban


class Transaction(models.Model):
    id = models.AutoField(primary_key=True)
    sender_account = models.ForeignKey(
        Customer, on_delete=models.SET_NULL, null=True, related_name="sender_account")
    receiver_account = models.ForeignKey(
        Customer, on_delete=models.SET_NULL, null=True, related_name="receiver_account")
    transaction_type = models.ForeignKey(
        TransactionType, on_delete=models.SET_NULL, null=True)
    expense_type = models.ForeignKey(
        ExpenseType, on_delete=models.SET_NULL, null=True)
    date_of_occurrence = models.DateField(auto_now_add=True)
    payment_reference = models.CharField(max_length=50)
    amount = models.DecimalField(decimal_places=2, max_digits=8)

    def __str__(self) -> str:
        return self.payment_reference
