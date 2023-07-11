import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import { ChakraProvider } from '@chakra-ui/react'
import { createStandaloneToast } from '@chakra-ui/react'
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import Login from './Components/Login/login.jsx'

const { ToastContainer } = createStandaloneToast()
const router = createBrowserRouter([
  {
    path:"/",element:<Login />
  },
  {
    path:"/dashboard",element:<App />
  }
])


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
  <ChakraProvider>
    <RouterProvider router={router} />
        <ToastContainer />
  </ChakraProvider>
  </React.StrictMode>,
)
