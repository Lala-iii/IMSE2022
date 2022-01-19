import React, { useState, useEffect } from "react";
import axios from "axios";

function CreateAccountFrom() {
  const [customers, setCustomers] = useState([]);

  const [iban, setIban] = useState("");
  const [accType, setAccType] = useState("");
  const [bic, setBic] = useState("");
  const [balance, setBalance] = useState("");
  const [currency, setCurrency] = useState("");
  const [owner, setOwner] = useState("none");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const account = {
      id: 0,
      account_type: accType,
      date_of_creation: new Date().toLocaleDateString(),
      iban: iban,
      bic: bic,
      balance: balance,
      currency: currency,
      owner: owner,
    };

    axios
      .post(`http://localhost:8080/account/`, account)
      //.then((result) => )
      .catch((error) => console.log("Error", error));
    console.log(account);
  };

  useEffect(() => {
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
              Create a new account
            </h1>

            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="owner"
              >
                Select Accout to create for Customer
              </label>
              <select
                className="w-full bg-indigo-100 px-4 py-2 h-8 rounded-lg focus:outline-none"
                required
                value={owner}
                name="owner"
                id="owner"
                placeholder=""
                onChange={(e) => setOwner(e.target.value)}
              >
                <option value="none">---Please select your Customer---</option>
                {customers.map((c) => {
                  return (
                    <option value={c.id}>
                      {c.firstname} {c.lastname}
                    </option>
                  );
                })}
              </select>
            </div>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="type"
              >
                Type
              </label>
              <input
                className="w-full bg-indigo-100 px-4 py-2 h-8 rounded-lg focus:outline-none"
                required
                value={accType}
                name="type"
                id="type"
                placeholder="Account type"
                onChange={(e) => setAccType(e.target.value)}
              />
            </div>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="iban"
              >
                IBAN
              </label>
              <input
                value={iban}
                onChange={(e) => {
                  setIban(e.target.value);
                }}
                name="iban"
                id="iban"
                class="w-full bg-indigo-100 px-4 py-1 rounded-lg focus:outline-none"
                type="text"
                placeholder="IBAN"
              />
            </div>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="bic"
              >
                BIC
              </label>
              <input
                value={bic}
                onChange={(e) => {
                  setBic(e.target.value);
                }}
                name="bic"
                id="bic"
                class="w-full bg-indigo-100 px-4 py-1 rounded-lg focus:outline-none"
                type="text"
                placeholder="BIC"
              />
            </div>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="balance"
              >
                Balance
              </label>
              <input
                value={balance}
                onChange={(e) => {
                  setBalance(e.target.value);
                }}
                name="balance"
                id="balance"
                class="w-full bg-indigo-100 px-4 py-1 rounded-lg focus:outline-none"
                type="text"
                placeholder="Balance"
              />
            </div>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="currency"
              >
                Currency
              </label>
              <input
                value={currency}
                onChange={(e) => {
                  setCurrency(e.target.value);
                }}
                name="currency"
                id="currency"
                class="w-full bg-indigo-100 px-4 py-1 rounded-lg focus:outline-none"
                type="text"
                placeholder="Currency"
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

export default CreateAccountFrom;
