from django.contrib import admin
from .models import Account, Customer, ExpenseType, Transaction, TransactionType

# Register your models here.


admin.site.register(Account)
admin.site.register(Transaction)
admin.site.register(Customer)
admin.site.register(ExpenseType)
admin.site.register(TransactionType)
