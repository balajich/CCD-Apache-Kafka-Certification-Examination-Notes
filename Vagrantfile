# vi: set ft=ruby :

ENV['VAGRANT_NO_PARALLEL'] = 'yes'

Vagrant.configure(2) do |config|
  
  config.vm.define "kserver" do |kserver|
    kserver.vm.box = "generic/centos7"
    kserver.vm.hostname = "kserver.eduami.org"
    kserver.vm.network "private_network", ip: "192.168.50.26"
    kserver.vm.network "forwarded_port", guest: 9021, host: 9021 # Confluent Control Center
    kserver.vm.network "forwarded_port", guest: 19092, host: 19092 # Broker -1
    kserver.vm.network "forwarded_port", guest: 29092, host: 29092 # Broker -2
    kserver.vm.network "forwarded_port", guest: 39092, host: 39092 # Broker -3
    kserver.vm.provision "shell", path: "startup-kserver.sh"
    kserver.vm.synced_folder ".", "/vagrant", type: "virtualbox"
    kserver.vm.provider "virtualbox" do |vb|
      vb.name = "kserver"
      vb.memory = 6072
      vb.cpus = 1
    end
  end
end
