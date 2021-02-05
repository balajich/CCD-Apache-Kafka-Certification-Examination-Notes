# vi: set ft=ruby :

ENV['VAGRANT_NO_PARALLEL'] = 'yes'

Vagrant.configure(2) do |config|
  
  config.vm.define "kserver" do |kserver|
    kserver.vm.box = "centos/7"
    kserver.vm.hostname = "kserver.eduami.org"
    kserver.vm.network "private_network", ip: "192.168.50.26"
    kserver.vm.network "forwarded_port", guest: 9090, host: 9090 # prometheus server
    kserver.vm.network "forwarded_port", guest: 3000, host: 3000 # grafana  server
    kserver.vm.provision "shell", path: "startup-kserver.sh"
    kserver.vm.provider "virtualbox" do |vb|
      vb.name = "kserver"
      vb.memory = 4024
      vb.cpus = 1
    end
  end
end
