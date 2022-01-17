import React, { useState, useEffect } from "react";
import axios from "axios";

function TransactionsList() {
  const [transaction, setTransaction] = useState({});
  const [changedExpenseType, setChangedExpenseType] = useState();
  const [transactions, setTransactions] = useState([]);
  const [customers, setCustomers] = useState([]);
  const [expenseTypes, setExpenseTypes] = useState([]);
  const [transactionTypes, setTransactionTypes] = useState([]);
  const [edit_id, setEditID] = useState("");
  const [currentExpenseType, setCurrentExpenseType] = useState("");

  const fetch = () => {
    axios
      .get(`http://localhost:8080/transaction/`)
      .then((result) => setTransactions(result.data))
      .catch((error) => console.log("Error", error));
  };
  useEffect(() => {
    fetch();
    axios
      .get(`http://localhost:8000/expense-type/`)
      .then((result) => setExpenseTypes(result.data))
      .catch((error) => console.log("Error", error));

    axios
      .get(`http://localhost:8000/transaction-type/`)
      .then((result) => setTransactionTypes(result.data))
      .catch((error) => console.log("Error", error));

    axios
      .get(`http://localhost:8000/customer/`)
      .then((result) => setCustomers(result.data))
      .catch((error) => console.log("Error", error));
  }, []);

  const put_transaction = () => {
    transaction.expense_type = changedExpenseType;
    console.log(transaction);
    axios
      .put(`http://localhost:8000/transaction/${transaction.id}/`, transaction)
      .then((result) => fetch())
      .catch((error) => console.log("Error", error));
    fetch();
  };
  return (
    <div class="overflow-auto lg:overflow-visible flex items-center justify-center min-h-screen col-span-12 bg-indigo-300">
      <table class="table text-gray-800 border-separate space-y-6 text-sm">
        <thead class="bg-indigo-200 text-gray-900">
          <tr>
            <th class="p-3 text-left">To</th>
            <th class="p-3 text-left">Transaction Type</th>
            <th class="p-3 text-left">Amount</th>
            <th class="p-3 text-left">Expense Category</th>
            <th class="p-3 text-left">Action</th>
          </tr>
        </thead>
        <tbody>
          {transactions?.map((item) => {
            const cust = customers?.find((c) => c.id === item.receiver_account);
            const ttype = transactionTypes?.find(
              (t) => t.id === item.transaction_type
            );

            const etype = expenseTypes?.find((e) => e.id === item.expense_type);
            return (
              <tr key={item.id} class="bg-indigo-200">
                <td class="p-3">
                  <div class="flex align-items-center">
                    <div class="ml-3">
                      <div class="">
                        {cust ? (
                          <div>
                            {cust.firstname} {cust.lastname}
                          </div>
                        ) : (
                          <div>no Data</div>
                        )}
                      </div>
                      <div class="text-gray-500"></div>
                      <div class="text-gray-500">{item.payment_reference}</div>
                    </div>
                  </div>
                </td>

                {ttype ? (
                  <td class="p-3">{ttype.description}</td>
                ) : (
                  <td class="p-3">No data</td>
                )}
                <td class="p-3 font-bold">{item.amount} €</td>
                <td class="p-3">
                  {etype ? (
                    <div>
                      {item.id === edit_id ? (
                        <div>
                          <select
                            className="bg-indigo-600 text-gray-50 rounded-md px-2"
                            required
                            name="expensetype"
                            id="expensetype"
                            value={currentExpenseType}
                            onChange={(e) => {
                              setChangedExpenseType(e.target.value);
                              setTransaction(item);
                              setCurrentExpenseType(e.target.value);
                            }}
                          >
                            {expenseTypes?.map((element) => {
                              return (
                                <option value={element.id}>
                                  {element.description}
                                </option>
                              );
                            })}
                          </select>
                        </div>
                      ) : (
                        <span class="bg-indigo-600 text-gray-50 rounded-md px-2">
                          {etype.description}
                        </span>
                      )}
                    </div>
                  ) : (
                    <span class="bg-green-400 text-gray-50 rounded-md px-2">
                      no Data
                    </span>
                  )}
                </td>
                <td class="p-3 ">
                  <a href="#" class="text-gray-500 hover:text-gray-100  mx-2">
                    {item.id === edit_id ? (
                      <button
                        class="material-icons-outlined text-base"
                        onClick={() => {
                          put_transaction();
                          setEditID(0);
                        }}
                      >
                        Save
                      </button>
                    ) : (
                      <button
                        class="material-icons-outlined text-base"
                        onClick={() => {
                          setEditID(item.id);
                          setCurrentExpenseType(item.expense_type);
                        }}
                      >
                        Edit
                      </button>
                    )}
                  </a>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}

export default TransactionsList;
