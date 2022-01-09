import React, { useState } from "react";
import { iban } from "../Dummy/Constants";

function CreateAccountFrom() {
  const [type, setType] = useState(iban);
  const [description, setDescription] = useState("");
  const handleSubmit = async (e) => {
    e.preventDefault();
    const transaction = {
      sender: type,
      receiver: description,
    };
    console.log(transaction);
  };
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
                for="type"
              >
                Type
              </label>
              <select
                className="w-full bg-indigo-100 px-4 py-2 h-8 rounded-lg focus:outline-none"
                required
                value={type}
                name="type"
                id="type"
                placeholder="type"
                onChange={(e) => setType(e.target.value)}
              >
                {iban.map((element) => {
                  return (
                    <option value={element.iban}>
                      {element.firstname} {element.lastname} -{" "}
                      {element.account_type}
                    </option>
                  );
                })}
              </select>
            </div>
            <div>
              <label
                class="text-gray-800 font-semibold block mt-3 text-md"
                for="description"
              >
                Description
              </label>
              <input
                value={description}
                onChange={(e) => {
                  setDescription(e.target.value);
                }}
                name="description"
                id="description"
                class="w-full bg-indigo-100 px-4 py-1 rounded-lg focus:outline-none"
                type="text"
                placeholder="description of the account"
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
