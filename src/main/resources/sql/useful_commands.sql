-------------------------------------|
---USEFULLY COMMANDS IN SQL AND DB---|
-------------------------------------|

\l - List all databases
\c <db-name> - Switch to another database
\dt - List database tables
\d <table-name> - Describe a table
\du - List users and their roles
\i - Run commands from a file
\q - Quit psql

--using forward slashes
\i <file/path/command_file.sql> - inside psql
psql -U <user> -d <db_name> -f <file/path/command_file.sql> - in cmd line

select enum_range(null::enum_user_role);
drop type enum_user_role;