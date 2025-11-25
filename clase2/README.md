# Clase 2 - Spring Boot Application

## Prerequisites

- Java 21
- Maven 3.9+
- Docker and Docker Compose

## Setup Instructions

### 1. Start MySQL Database

The project uses Docker to run MySQL. Start the database with:

```bash
docker-compose up -d
```

This will:
- Create a MySQL 8.0 container
- Create database `mydatabase`
- Set up user `cibertec` with password `cibertec`
- Expose MySQL on port 3306

Check if MySQL is running:
```bash
docker-compose ps
```

View MySQL logs:
```bash
docker-compose logs -f mysql
```

### 2. Environment Variables

Database credentials are stored in `.env` file (already configured):
- `username=cibertec`
- `password=cibertec`

**Note:** The `.env` file is excluded from git for security.

### 3. Run the Application

```bash
mvn spring-boot:run
```

Or with environment variables explicitly set:
```bash
export username=cibertec
export password=cibertec
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Useful Commands

### Stop MySQL
```bash
docker-compose down
```

### Stop MySQL and remove data
```bash
docker-compose down -v
```

### Restart MySQL
```bash
docker-compose restart
```

### Access MySQL CLI
```bash
docker exec -it clase2-mysql mysql -u cibertec -pcibertec mydatabase
```

## Project Structure

- `src/main/java` - Java source code
- `src/main/resources` - Configuration files
- `docker-compose.yml` - MySQL container configuration
- `.env` - Environment variables (not in git)

## Troubleshooting

### Connection refused error
Make sure MySQL container is running:
```bash
docker-compose ps
```

### Port 3306 already in use
Stop any local MySQL service or change the port in `docker-compose.yml`
