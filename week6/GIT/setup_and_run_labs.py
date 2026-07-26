import subprocess
import os

def run_git_cmd(args, cwd):
    # Force git to use standard configuration settings and not prompt
    result = subprocess.run(args, cwd=cwd, capture_output=True, text=True)
    if result.returncode != 0:
        print(f"Error in {cwd} executing {' '.join(args)}:\nStdout: {result.stdout}\nStderr: {result.stderr}")
    return result

base_dir = r"d:\Digital-Nurture-5.0-Java-Cognizant\week6\GIT"

# Set up Git configurations locally inside repositories to prevent editing global config
def init_repo(path):
    os.makedirs(path, exist_ok=True)
    run_git_cmd(["git", "init"], path)
    run_git_cmd(["git", "config", "user.name", "Student"], path)
    run_git_cmd(["git", "config", "user.email", "student@example.com"], path)

# ----------------- Lab 1 -----------------
print("Setting up Lab 1...")
lab1_path = os.path.join(base_dir, "hands_on_1")
init_repo(lab1_path)
with open(os.path.join(lab1_path, "welcome.txt"), "w") as f:
    f.write("Welcome to Git Hands-on Lab 1!\n")
run_git_cmd(["git", "add", "welcome.txt"], lab1_path)
run_git_cmd(["git", "commit", "-m", "Initial commit with welcome.txt"], lab1_path)

# ----------------- Lab 2 -----------------
print("Setting up Lab 2...")
lab2_path = os.path.join(base_dir, "hands_on_2")
init_repo(lab2_path)
# Create a .log file and a log folder
with open(os.path.join(lab2_path, "error.log"), "w") as f:
    f.write("Some fake error logs\n")
os.makedirs(os.path.join(lab2_path, "log"), exist_ok=True)
with open(os.path.join(lab2_path, "log", "debug.txt"), "w") as f:
    f.write("Some debug log text\n")
# Create .gitignore
with open(os.path.join(lab2_path, ".gitignore"), "w") as f:
    f.write("*.log\nlog/\n")
run_git_cmd(["git", "add", ".gitignore"], lab2_path)
run_git_cmd(["git", "commit", "-m", "Add .gitignore to ignore log files and folders"], lab2_path)

# ----------------- Lab 3 -----------------
print("Setting up Lab 3...")
lab3_path = os.path.join(base_dir, "hands_on_3")
init_repo(lab3_path)
with open(os.path.join(lab3_path, "main.txt"), "w") as f:
    f.write("Main trunk content\n")
run_git_cmd(["git", "add", "main.txt"], lab3_path)
run_git_cmd(["git", "commit", "-m", "Initial commit on master"], lab3_path)
# Branch
run_git_cmd(["git", "branch", "GitNewBranch"], lab3_path)
run_git_cmd(["git", "checkout", "GitNewBranch"], lab3_path)
with open(os.path.join(lab3_path, "feature.txt"), "w") as f:
    f.write("Feature branch content\n")
run_git_cmd(["git", "add", "feature.txt"], lab3_path)
run_git_cmd(["git", "commit", "-m", "Add feature.txt in branch"], lab3_path)
# Merge back
run_git_cmd(["git", "checkout", "master"], lab3_path)
run_git_cmd(["git", "merge", "GitNewBranch", "-m", "Merge branch GitNewBranch into master"], lab3_path)
run_git_cmd(["git", "branch", "-d", "GitNewBranch"], lab3_path)

# ----------------- Lab 4 -----------------
print("Setting up Lab 4...")
lab4_path = os.path.join(base_dir, "hands_on_4")
init_repo(lab4_path)
xml_content = """<hello>
    <message>Hello World</message>
</hello>
"""
with open(os.path.join(lab4_path, "hello.xml"), "w") as f:
    f.write(xml_content)
run_git_cmd(["git", "add", "hello.xml"], lab4_path)
run_git_cmd(["git", "commit", "-m", "Initial hello.xml"], lab4_path)

# Create branch GitWork
run_git_cmd(["git", "checkout", "-b", "GitWork"], lab4_path)
with open(os.path.join(lab4_path, "hello.xml"), "w") as f:
    f.write("""<hello>
    <message>Hello World from GitWork Branch</message>
</hello>
""")
run_git_cmd(["git", "add", "hello.xml"], lab4_path)
run_git_cmd(["git", "commit", "-m", "Update hello.xml on GitWork branch"], lab4_path)

# Switch back to master and modify
run_git_cmd(["git", "checkout", "master"], lab4_path)
with open(os.path.join(lab4_path, "hello.xml"), "w") as f:
    f.write("""<hello>
    <message>Hello World from Master Branch</message>
</hello>
""")
run_git_cmd(["git", "add", "hello.xml"], lab4_path)
run_git_cmd(["git", "commit", "-m", "Update hello.xml on Master branch"], lab4_path)

# Try merging (expecting conflict)
merge_res = run_git_cmd(["git", "merge", "GitWork"], lab4_path)
# Resolve conflict
with open(os.path.join(lab4_path, "hello.xml"), "w") as f:
    f.write("""<hello>
    <message>Hello World from Master Branch (Resolved Conflict)</message>
</hello>
""")
run_git_cmd(["git", "add", "hello.xml"], lab4_path)
run_git_cmd(["git", "commit", "-m", "Merge branch GitWork and resolve conflicts"], lab4_path)

# Add backups to .gitignore
with open(os.path.join(lab4_path, ".gitignore"), "w") as f:
    f.write("*.bak\n*.orig\n")
run_git_cmd(["git", "add", ".gitignore"], lab4_path)
run_git_cmd(["git", "commit", "-m", "Add backup files to gitignore"], lab4_path)
run_git_cmd(["git", "branch", "-d", "GitWork"], lab4_path)

# ----------------- Lab 5 -----------------
print("Setting up Lab 5...")
lab5_path = os.path.join(base_dir, "hands_on_5")
init_repo(lab5_path)

# Setup a local bare repository to act as origin/remote
remote_path = os.path.join(base_dir, "mock_remote.git")
os.makedirs(remote_path, exist_ok=True)
subprocess.run(["git", "init", "--bare"], cwd=remote_path, capture_output=True)

with open(os.path.join(lab5_path, "final.txt"), "w") as f:
    f.write("Final commit content\n")
run_git_cmd(["git", "add", "final.txt"], lab5_path)
run_git_cmd(["git", "commit", "-m", "Commit final changes"], lab5_path)

run_git_cmd(["git", "remote", "add", "origin", "../mock_remote.git"], lab5_path)
run_git_cmd(["git", "push", "-u", "origin", "master"], lab5_path)

print("All Git Labs successfully completed!")
