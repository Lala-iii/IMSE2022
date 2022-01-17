import React, { useState } from "react";
import axios from "axios";
import { transactions } from "../Dummy/Constants";

function ContactList() {
  const [customers, setCustomers] = useState([]);

  axios
    .get(`http://localhost:8080/customer/`)
    .then((result) => setCustomers(result.data))
    .catch((error) => console.log("Error", error));
  return (
    <div>
      <div class="flex items-center justify-center min-h-screen bg-indigo-300">
        <div class="col-span-12">
          <div class="overflow-auto lg:overflow-visible ">
            <table class="table text-gray-800 border-separate space-y-6 text-sm">
              <thead class="bg-indigo-200 text-gray-900">
                <tr>
                  <th class="p-3 text-left">Customer</th>
                  <th class="p-3 text-left">Gender</th>
                  <th class="p-3 text-left">SVNR</th>
                  <th class="p-3 text-left">Date of birth</th>
                  <th class="p-3 text-left">Address</th>
                  <th class="p-3 text-left">Action</th>
                </tr>
              </thead>
              <tbody>
                {customers.map((item) => {
                  return (
                    <tr class="bg-indigo-200">
                      <td class="p-3">
                        <div class="flex align-items-center">
                          <div class="ml-3">
                            <div class="">
                              {item.id}: {item.firstname} {item.lastname}
                            </div>
                          </div>
                        </div>
                      </td>
                      <td class="p-3">
                        <span class="flex align-items-center">
                          {item.gender}
                        </span>
                      </td>
                      <td class="p-3">
                        <span class="flex align-items-center">{item.svnr}</span>
                      </td>
                      <td class="p-3">
                        <span class="flex align-items-center">
                          {item.date_of_birth}
                        </span>
                      </td>
                      <td class="p-3">
                        <span class="flex align-items-center">
                          {item.address}
                        </span>
                      </td>
                      <td class="p-3 ">
                        <a
                          href="#"
                          class="text-gray-500 hover:text-gray-100  mx-2"
                        >
                          <i class="material-icons-outlined text-base">edit</i>
                        </a>
                        <a
                          href="#"
                          class="text-gray-500 hover:text-gray-100  ml-2"
                        >
                          <i class="material-icons-round text-base">delete</i>
                        </a>
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ContactList;
