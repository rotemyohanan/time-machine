### Git 

Under the git directory
    
    git init
The response will be
Initialized empty Git repository in **/Users/rotemy/Desktop/gitfun/.git/**
We now have a new repository!

Git has configured a few things:
 1. **.git** directory, under which things are stored.  
 2. **.git/objects"** which is where Git stores things.

    $ ls .git/objects
    info/  pack/


    
Fetch the specified remote's copy of the specified branch and merge it into the local copy.
    
    git pull <remote>
    
Equivalent to:

    git fetch <remote>
    git merge origin/<current-branch>
    
    git pull --rebase <remote>
    The same as the above but instead 'merge' performs 'rebase'

 > rebase - put my changes on top of the current developement process.

    
Error:
Connection to the stash has no ping.
1. try to ping to o


// ------------------ Git Flow ---------------------- //
// Initializing inside an existing git repository.
git flow init

// Start developing a new feature with:
git flow feature start <myFeature> // create a new feature based on 'develop' and switch to it.
// Finish developing a feature with:
git flow feature start <myFeature> // Merge the feature into the 'develop' Remove the feature branch, switch back to the 'develop' branch

// Publish developing a feature with: (when working in collaboration )
git flow feature publish <myFeature>  // publishing to a remote server so can be using by other users.

// Getting a feature that was published by another user.
git flow feature pull origin <myFeature>
    
// Tracking a feature on origin:
git flow feature track <myFeature>
    
// Release - supports preperation of a new production release
//         - allows a mirror bug fixes and preparing meta data for release.
git flow release start RELEASE [base] // create a release branch from 'develop' branch.
                                // can be sha-1 hash to start the release from.

git flow release publish RELEASE
//Tracking a remote release
git flow release track RELEASE

// Finishing the release 
git flow release finish RELEASE // Merges the release branch back into the master, tags the release with name, merge the release back into 'develop'
                                // Removes the release branch.

// Do not forget: push the tags
git push --tags

// Hotfix: immediately correcting undesired state of a live production version.
git flow hotfix start VERSION [BASENAME]
// Finishing a hotfix.
git flow hotfix finish VERSION 

// Uploading to production:
1. Upload to production
2. Merge to 'develop'
3. Merge to 'master'
4. Finish

// Feature branch - for big code change

//
GIT - revision control systems
git using the calculated SHA1 key

Rebasing is a way to push commits from a branch on top of another branch
Rebase - cut of a set of commits from a branch and apply those commits on another branch
(If everything went fine, we get a nice linear history)
Great for fixing bugs - get the damaged branch and add commit to fix the problem above it.

Rules:
    Never ever rebase a branch that you pushed, or that you pulled from another person

Merge:
    - Join two or more development histories together



#### New Branch

Before creating a new branch, pull the changes from upstream. Your master needs to be up to date.
```javascript
$ git pull
```
Create the branch on your local machine and switch in this branch :
```javascript
$ git checkout -b [name_of_your_new_branch]
```
Push the branch on github :
```javascript
$ git push origin [name_of_your_new_branch]
```
When you want to commit something in your branch, be sure to be in your branch. Add -u parameter to set upstream.

You can see all branches created by using :
```javascript
$ git branch -a
```


Git reset hard to a specific commit (reject the few commits I had before)
```
git reset --hard <sha1_of_where_you_want_to_be>
```



### Delete a branch

```javascript
git branch -d branch_name
git push <remote_name> --delete <branch_name>

code example:
git branch -d dev1
git push origin --delete dev1

```
