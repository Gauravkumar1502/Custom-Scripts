<#
.SYNOPSIS
    Executes a command and copies its output to the clipboard.
.DESCRIPTION
    Takes a command as an argument, executes it, and copies its output to the clipboard. Prints "Output copied successfully!" after copying the output.
    If the -o or --output switch is provided before the command, also prints the command output to the console.
.EXAMPLE
    co -o "ls | findstr Vi"

    Executes "ls | findstr Vi", copies its output to the clipboard, prints the output to the console, and prints "Output copied successfully!".
.OUTPUTS
    System.String
#>
# co command for PowerShell
function co {
    param (
        [switch]$o = $false,
        [Parameter(ValueFromRemainingArguments=$true)]
        [string[]]$command
    )
    try {
        $output = Invoke-Expression ($command -join " ")
        $output | Set-Clipboard
        if ($o) {
            Write-Output $output
            Write-Output ""	
        }
        Write-Output "Command output copied to clipboard successfully!"
    }
    catch {
        Write-Error "An error occurred while executing the command: $_"
    }
}#co
