# Ethihat Store

Ethihat Store is a Spring Boot-based application that provides an e-commerce backend to manage products and users. It features a secure user authentication system and an intuitive API for product management.

## Table of Contents
1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Setup and Installation](#setup-and-installation)
4. [Configuration](#configuration)
5. [API Endpoints](#api-endpoints)
6. [Running the Application](#running-the-application)
7. [License](#license)

---

## Features
- **Product Management**:
  - Create, update, delete, and fetch product details.
- **User Authentication**:
  - User registration and login.
  - JWT-based secure authentication.
- **Role-Based Access Control**:
  - Control access to specific APIs based on user roles.
- **Security**:
  - Password encryption using BCrypt.
  - Stateless authentication using JWT.

## Technologies Used
- **Backend**:
  - Spring Boot (Version 3.3.4)
  - Spring Security
  - MongoDB
- **Authentication**:
  - JWT (JSON Web Token)
- **Build Tool**:
  - Maven
- **Others**:
  - Lombok
  - Validation with Spring Boot
  - Docker (Optional)

## Setup and Installation

### Prerequisites
- JDK 17 or later
- Maven
- MongoDB running locally or accessible remotely

### Steps to Set Up
1. Clone the repository:
   ```bash
   git clone <repository_url>
   cd Ethihat-Store
