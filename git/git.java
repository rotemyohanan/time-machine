
// Fetch the specified remote's copy of the specified branch and merge it into the local copy.
git pull <remote>
//Equivalent to:
git fetch <remote>
git merge origin/<current-branch>
    
git pull --rebase <remote>
the same as the above but instead 'merge' performs 'rebase'

rebase - put my changes on top of the current developement process.

    
Error:
Connection to the stash has no ping.
1. try to ping to o
