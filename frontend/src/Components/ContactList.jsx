import React, { useState } from "react";
import { transactions } from "../Dummy/Constants";

function ContactList() {
  const [data, setData] = useState(transactions);
  return (
    <div>
      <div class="flex items-center justify-center min-h-screen bg-indigo-300">
        <div class="col-span-12">
          <div class="overflow-auto lg:overflow-visible ">
            <table class="table text-gray-800 border-separate space-y-6 text-sm">
              <thead class="bg-indigo-200 text-gray-900">
                <tr>
                  <th class="p-3 text-left">Contact</th>
                  <th class="p-3 text-left">Category</th>
                  <th class="p-3 text-left">Action</th>
                </tr>
              </thead>
              <tbody>
                {data.map((item) => {
                  return (
                    <tr class="bg-indigo-200">
                      <td class="p-3">
                        <div class="flex align-items-center">
                          <div class="ml-3">
                            <div class="">
                              {item.receiver.firstname} {item.receiver.lastname}
                            </div>
                            <div class="text-gray-500">
                              {item.receiver.iban}
                            </div>
                          </div>
                        </div>
                      </td>
                      <td class="p-3">
                        <span class="bg-green-400 text-gray-50 rounded-md px-2">
                          {item.category}
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
