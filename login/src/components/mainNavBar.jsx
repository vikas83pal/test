import React from 'react'

const mainNavBar = () => {
  return (
    <>
    <header className="text-gray-600 body-font sticky top-0 no-underline border-0 shadow-md bg-transparent">
      <div className="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
        <a 
          href="/" 
          className="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0"
          aria-label="Shopping Mall Homepage"
        >
          <span className="ml-3 text-xl">Shopping Mall</span>
        </a>
        <nav className="md:ml-auto md:mr-auto flex flex-wrap items-center text-base justify-center">
          <Link 
            to="/" 
            className="mr-5 hover:text-gray-900  focus:ring-gray-500"
            aria-label="Navigate to Home Page"
          >
            Home
          </Link>
          <Link 
            to="/register" 
            className="mr-5 hover:text-gray-900 focus:outline-none focus:ring-gray-500"
            aria-label="Navigate to Register Page"
          >
            Register
          </Link>
          <Link 
            to="/login" 
            className="mr-5 hover:text-gray-900 focus:outline-none focus:ring-gray-500"
            aria-label="Navigate to Login Page"
          >
            Login
          </Link>
          <Link 
            to="/" 
            className="mr-5 hover:text-gray-900 focus:outline-none focus:ring-gray-500"
            aria-label="Navigate to Login Page"
          >
            Cart
          </Link>
          <Link 
            to="/" 
            className="mr-5 hover:text-gray-900 focus:outline-none focus:ring-gray-500"
            aria-label="Navigate to Login Page"
          >
            Catalog
          </Link>
          <Link 
            to="/" 
            className="mr-5 hover:text-gray-900 focus:outline-none focus:ring-gray-500"
            aria-label="Navigate to Login Page"
          >
            Contact us
          </Link>
        </nav>
      </div>
    </header>
  </>
  )
}

export default mainNavBar