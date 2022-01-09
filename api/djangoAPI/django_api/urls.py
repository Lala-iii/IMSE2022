from django.urls import path
from rest_framework.generics import GenericAPIView
from .views import AccountGenericAPIView, CustomerGenericAPIView, ExpenseTypeGenericAPIView, TransactionGenericAPIView, TransactionTypeGenericAPIView

urlpatterns = [
    path('account/', AccountGenericAPIView.as_view()),
    path('transaction/', TransactionGenericAPIView.as_view()),
    path('customer/', CustomerGenericAPIView.as_view()),
    path('expense-type/', ExpenseTypeGenericAPIView.as_view()),
    path('transaction-type/', TransactionTypeGenericAPIView.as_view()),
    path('account/<int:id>/', AccountGenericAPIView.as_view()),
    path('transaction/<int:id>/', TransactionGenericAPIView.as_view()),
    path('customer/<int:id>/', CustomerGenericAPIView.as_view()),
    path('expense-type/<int:id>/', ExpenseTypeGenericAPIView.as_view()),
    path('transaction-type/<int:id>/', TransactionTypeGenericAPIView.as_view())
]
