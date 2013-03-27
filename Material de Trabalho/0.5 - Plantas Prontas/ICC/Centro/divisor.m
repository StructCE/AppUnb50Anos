clear all
close all

nome = 'ICC_CENTRO_SS';
bSize = 512;


imgNome = strcat(nome, '.png');
imagem = imread(imgNome);

[h, l] = size(imagem);

i = ceil(h/bSize);
j = ceil(l/bSize);

h = i*bSize;
l = j*bSize;

imagem = imresize(imagem, [h, l]);

bloco = zeros(bSize, bSize, 3);
for p = 1:i
    for k = 1: j
        bloco(:, :, :) = imagem((p-1)*bSize + 1:(p-1)*bSize+512, (k-1)*bSize+1:(k-1)*bSize+512, :);
        blockname = strcat(nome,'-', int2str(p),'-', int2str(k), '.png');
        imwrite(bloco, blockname, 'png');
    end
end






