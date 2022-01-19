import React, { useState, useEffect } from "react";
import axios from "axios";

function TransactionForm() {
  const [from, setFrom] = useState("none");

  const [fromiban, setFromiban] = useState("none");
  const [toiban, setToiban] = useState("none");
  const [to, setTo] = useState("");
  const [type, setType] = useState("");
  const [ref, setRef] = useState("");
  const [amount, setAmount] = useState("");
  const [eType, setEType] = useState("");

  const [accfilteredFrom, setAccfilteredFrom] = useState([]);
  const [accfilteredTo, setAccfilteredTo] = useState([]);
  const [customers, setCustomers] = useState([]);
  const [accounts, setAccounts] = useState([]);

  const classError =
    "w-full bg-indigo-100 px-4 py-2 h-8 rounded-lg focus:outline-none";
  const classNoError =
    "w-full bg-indigo-100 px-4 py-2 h-8 rounded-lg focus:outline-none";
  let error = false;
  const handleSubmit = async (e) => {
    e.preventDefault();
    if (from === "none") error = true;
    else error = false;
    const transaction = {
      id: 0,
      sender_account: fromiban,
      receiver_account: toiban,
      expense_type: eType,
      transaction_type: type,
      date_of_occurrence: new Date().toLocaleDateString(),
      payment_reference: ref,
      amount: amount,
    };
    axios
      .post(`http://localhost:8080/transaction/`, transaction)
      //.then((result) => )
      .catch((error) => console.log("Error", error));
    console.log(transaction);
  };

  const getAccountsOfOwnerFrom = (owner) => {
    setAccfilteredFrom(accounts.filter((a) => a.owner == owner));
  };
  const getAccountsOfOwnerTo = (owner) => {
    setAccfilteredTo(accounts.filter((a) => a.owner == owner));
  };

  useEffect(() => {
    axios
      .get(`http://localhost:8080/account/`)
      .then((result) => setAccounts(result.data))
      .catch((error) => console.log("Error", error));

    axios
      .get(`http://localhost:8080/customer/`)
      .then((result) => setCustomers(result.data))
      .catch((error) => console.log("Error", error));
  }, []);

  return (
    <div>
      <div class="h-screen bg-indigo-300 flex justify-center items-center">
        <div class="lg:w-2/5 md:w-1/2 w-2/3">
          <form class="bg-indigo-200 p-10 rounded-lg shadow-lg min-w-full">
            <h1 class="text-center text-2xl mb-3 text-gray-600 font-bold font-sans">
              Create a new transaction
            </h1>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="from"
              >
                From
              </label>
              <select
                className={error ? classError : classNoError}
                required
                value={from}
                name="from"
                id="from"
                placeholder="from"
                onChange={(e) => {
                  setFrom(e.target.value);
                  getAccountsOfOwnerFrom(e.target.value);
                }}
              >
                <option value="none">---Please select your Customer---</option>
                {customers?.map((cust_from) => {
                  return (
                    <option value={cust_from.id}>
                      {cust_from.firstname} {cust_from.lastname}
                    </option>
                  );
                })}
              </select>
            </div>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="fromiban"
              >
                From IBAN
              </label>
              <select
                className={error ? classError : classNoError}
                required
                value={fromiban}
                name="fromiban"
                id="fromiban"
                placeholder=""
                onChange={(e) => {
                  setFromiban(e.target.value);
                }}
              >
                <option value="none">
                  ---Please select your Customers IBAN---
                </option>
                {accfilteredFrom?.map((cust_acc_from) => {
                  return (
                    <option value={cust_acc_from.id}>
                      {cust_acc_from.id}: {cust_acc_from.iban}
                    </option>
                  );
                })}
              </select>
            </div>

            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="to"
              >
                To
              </label>
              <select
                className="w-full bg-indigo-100 px-4 py-2 h-8 rounded-lg focus:outline-none"
                required
                value={to}
                name="to"
                id="to"
                placeholder="to"
                onChange={(e) => {
                  setTo(e.target.value);
                  getAccountsOfOwnerTo(e.target.value);
                }}
              >
                <option value="">---Please select your contact---</option>
                {customers?.map((cust_to) => {
                  return (
                    <option value={cust_to.id}>
                      {cust_to.firstname} {cust_to.lastname}
                    </option>
                  );
                })}
              </select>
            </div>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="to"
              >
                To IBAN
              </label>
              <select
                className="w-full bg-indigo-100 px-4 py-2 h-8 rounded-lg focus:outline-none"
                required
                value={toiban}
                name="toiban"
                id="toiban"
                placeholder=""
                onChange={(e) => setToiban(e.target.value)}
              >
                <option value="none">---Please select your contact---</option>
                {accfilteredTo?.map((cust_acc_to) => {
                  return (
                    <option value={cust_acc_to.id}>{cust_acc_to.iban}</option>
                  );
                })}
              </select>
            </div>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="transaction_type"
              >
                Transaction Type
              </label>
              <input
                className="w-full bg-indigo-100 px-4 py-2 h-8 rounded-lg focus:outline-none"
                required
                value={type}
                name="transaction_type"
                id="transaction_type"
                placeholder=""
                type="text"
                onChange={(e) => setType(e.target.value)}
              />
            </div>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="expense_type"
              >
                Expense Type
              </label>
              <input
                className="w-full bg-indigo-100 px-4 py-2 h-8 rounded-lg focus:outline-none"
                required
                value={eType}
                name="expense_type"
                id="expense_type"
                placeholder=""
                type="text"
                onChange={(e) => setEType(e.target.value)}
              />
            </div>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="transaction_reference"
              >
                Transaction Reference
              </label>
              <input
                value={ref}
                onChange={(e) => {
                  setRef(e.target.value);
                }}
                class="w-full bg-indigo-100 px-4 py-1 rounded-lg focus:outline-none"
                type="text"
                name="transaction_reference"
                id="transaction_reference"
                placeholder="Transaction Reference"
              />
            </div>

            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="amount"
              >
                Amount
              </label>
              <input
                value={amount}
                onChange={(e) => {
                  setAmount(e.target.value);
                }}
                class="w-full bg-indigo-100 px-4 py-2 rounded-lg focus:outline-none"
                type="text"
                name="amount"
                id="amount"
                placeholder="Amount in Euro"
              />
            </div>
            <button
              type="submit"
              onClick={(e) => handleSubmit(e)}
              class="w-full mt-4 bg-indigo-500 rounded-lg px-4 py-1 text-lg text-gray-100 tracking-wide font-semibold font-sans"
            >
              Submit
            </button>
            <button
              type="submit"
              class="w-full mt-4 bg-indigo-100 rounded-lg px-4 py-1 text-lg text-gray-800 tracking-wide font-semibold font-sans"
            >
              Clear
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}

export default TransactionForm;
