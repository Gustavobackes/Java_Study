#!/bin/bash

RED='\033[1;31m'
GREEN='\033[1;32m'
YELLOW='\033[1;33m'
BLUE='\033[1;34m'
ROSE='\033[1;35m'
NC='\033[0m'

printf ${BLUE}
echo " "
echo "--------------------------"
echo "DESEJA ATUALIZAR O FRONT?"
echo "     (S/N)"
echo "--------------------------"
printf ${NC}
read front;
while [ "$front" == "s" ]; do
cd /
cd /home/gustavobackes/dev/projuris/enterprise-frontend/projuris-enterprise-app

default=null
printf ${BLUE}
echo "---------------------------"
echo " ESCOLHA A BRANCH DEFAULT"
echo "1 -> develop | 2 -> master"
echo "---------------------------"
printf ${NC}
read escolha;
if [ $escolha == "1" ];
  then 
    default="develop"
  else
    default="master"
   
fi

 git fetch --prune
    branch=$(git branch --show-current)
    if [ "$branch" == "$default" ];
      then
        resl=$(git pull)
        if [ "$resl"  == "Already up to date." ];
          then
            echo "SEM ALTERAÇÃO"
        else
          yarn install
          printf ${YELLOW}
          echo " "
          echo "ATUALIZADO"
          printf ${NC}
        fi

else
      git checkout ${default}
      git pull
      yarn install
      printf ${YELLOW}
      echo " "
      echo "ATUALIZADO"
      printf ${NC}
    fi
done









